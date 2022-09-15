create table product_meta_table
(
    id          bigserial   not null
        constraint product_meta_table_pk
            primary key,
    product_id bigint      not null,
    key_        varchar(50) not null,
    content_    text
);

alter table product_meta_table
    owner to postgres;

create
    unique index product_meta_table_productid_uindex
    on product_meta_table (product_id);

create table product_table
(
    id            bigserial                     not null
        constraint product_table_pk
            primary key,
    user_id     bigint                        not null,
    title         varchar(100)     default NULL:: character varying,
    summary       text,
    type_         smallint         default 0    not null,
    price         double precision default 0    not null,
    discount      double precision default 0    not null,
    quantity      smallint         default 0    not null,
    available     boolean          default true not null,
    created_at   timestamp                     not null,
    updated_at   timestamp,

    content_      text
);

alter table product_table
    owner to postgres;

create
    unique index product_table_id_uindex
    on product_table (id);
create table user_table
(
    id             bigserial                 not null
        constraint user_table_pk
            primary key,
    name varchar(50) default NULL:: character varying,
    surname    varchar(50) default NULL:: character varying,
    mobile         varchar(15) default NULL:: character varying,
    email          varchar(50) default NULL:: character varying,
    password_hash varchar(32)               not null,
    admin          boolean     default false not null,
    registered_at timestamp                 not null,
    last_login   timestamp,
    profile        text
);



alter table user_table
    owner to postgres;

create
    unique index user_table_email_uindex
    on user_table (email);

create
    unique index user_table_mobile_uindex
    on user_table (mobile);

create table product_review_table
(
    id            bigserial               not null
        constraint product_review_table_pk
            primary key,
    product_id   bigint                  not null,
    parent_id   bigint    default null,
    title         varchar(100)            not null,
    rating        smallint  default 5     not null check (rating between 0 and 5),
    published     bool      default false not null,
    created_at  timestamp               not null,
    published_at timestamp default null,
    content_      text      default null
);

comment
    on column product_review_table.rating is 'nadji nacin da limitiras od 0 do 5';

create table category_table
(
    id         bigserial   not null
        constraint category_table_pk
            primary key,
    parent_id bigint default null,
    title      varchar(75) not null,
    content_   text   default null
);
    create table product_category_table
        (
        product_id    int REFERENCES product_table (id) ON UPDATE CASCADE ON DELETE CASCADE
        , category_id int REFERENCES category_table (id) ON UPDATE CASCADE
        , CONSTRAINT category_product_pkey PRIMARY KEY (category_id, product_id)  -- explicit pk
        );


create table cart_table
(
    id          bigserial              not null
        constraint cart_table_pk
            primary key,
    user_id   bigint       default null
        constraint cart_table_user_fk
            references user_table,

    token       varchar(100)           not null,
    status      smallint     default 0 not null check (status between 0 and 5),
    name_       varchar(50)  default null,
    surname     varchar(50)  default null,
    mobile      varchar(15)  default null,
    email       varchar(50)  default null,
    address     varchar(100) default null,
    city        varchar(50)  default null,
    country     varchar(50)  default null,
    created_at timestamp              not null,
    updated_at timestamp    default null,
    content_    text         default null
);

comment
    on column cart_table.status is 'limitiraj od 0-5 0.new 1.cart 2.checkout 3.paid 4.complete 5.abandoned';

create
    index cart_table_userid_index
    on cart_table (user_id);

create table cart_item_table
(
    id          bigserial           not null
        constraint cart_item_table_pk
            primary key,
    product_id bigint              not null
        constraint cart_item_product_fk
            references product_table,
    cart_id   bigint              not null
        constraint cart_item_cart_fk
            references cart_table,
    price       float               not null,
    discount    float     default 0 not null,
    quantity    smallint  default 0 not null,
    active      bool      default false,
    created_at timestamp           not null,
    updated_at timestamp default null,
    content_    text      default null
);

create
    index cart_item_cart_index
    on cart_item_table (cart_id);

create
    index cart_item_product_index
    on cart_item_table (product_id);

create table order_table
(
    id             bigserial              not null
        constraint order_table_pk
            primary key,
    user_id       bigint       default null
        constraint order_table_user_fk
            references user_table,

    token          varchar(100)           not null,
    status         smallint     default 0 not null check (status between 0 and 5),
    sub_total    float                  not null,
    item_discount float        default 0 not null,
    shipping       float        default 0 not null,
    total          float                  not null,
    discount       float                  not null,
    grand_total   float                  not null,
    name_          varchar(50)  default null,
    surname        varchar(50)  default null,
    email          varchar(50)  default null,
    mobile         varchar(15)  default null,
    address        varchar(100) default null,
    city           varchar(50)  default null,
    country        varchar(50)  default null,
    created_at   timestamp              not null,
    updated_at    timestamp    default null,
    content_       text         default null
);

comment
    on column order_table.status is 'limit na 0-5 0.new 1.checkout 2.shipped 3.deliverd 4.complete 5.returned';

comment
    on column order_table.shipping is 'cijena dostave';

comment
    on column order_table.total is 'total= subtotal + shipping (bez popusta)';

comment
    on column order_table.grand_total is 'grandTotal=total-popust';

create
    index order_table_user_index
    on order_table (user_id);
create table order_item_table
(
    id          bigserial           not null
        constraint order_item_table_pk
            primary key,
    product_id bigint              not null
        constraint order_item_table_product_fk
            references product_table,
    order_id  bigint              not null
        constraint order_item_table_order_fk
            references order_table,
    price       float     default 0 not null,
    discount    float     default 0 not null,
    quantity    smallint  default 0 not null,
    created_at timestamp           not null,
    updated_at timestamp default null,
    content_    text      default null
);

create
    index order_item_order_index
    on order_item_table (order_id);

create
    index order_item_product_index
    on order_item_table (product_id);
create table transaction_table
(
    id          bigserial           not null
        constraint transaction_table_pk
            primary key,
    user_id    bigint              not null
        constraint transaction_table_user_fk
            references user_table,
    order_id   bigint              not null
        constraint transaction_table_order_fk
            references order_table,
    status      smallint  default 0 not null check (status between 0 and 6),
    created_at timestamp           not null,
    updated_at timestamp default null,
    content_    text      default null
);

comment
    on column transaction_table.status is 'limit 0-6 0.new 1.cancelled 2.failed 3.pending 4.declined 5.rejected 6.success';

create
    index transaction_table_order_index
    on transaction_table (order_id);

create
    index transaction_table_user_index
    on transaction_table (user_id);

create
    index product_table_user_index
    on product_table (user_id);

alter table product_table
    add constraint product_table_user_fk
        foreign key (user_id) references user_table;

create
    index product_meta_table_product_index
    on product_meta_table (key_, product_id);

alter table product_meta_table
    add constraint product_meta_table_product_fk
        foreign key (product_id) references product_table;
create
    index product_review_table_parent_index
    on product_review_table (parent_id);

create
    index product_review_table_product_index
    on product_review_table (product_id);

alter table product_review_table
    add constraint product_review_table_parent_fk
        foreign key (parent_id) references product_review_table;

alter table product_review_table
    add constraint product_review_table_product_fk
        foreign key (product_id) references product_table;
create
    index category_table_parent_index
    on category_table (parent_id);

alter table category_table
    add constraint category_table_category_table_id_fk
        foreign key (parent_id) references category_table;
create
    unique index product_category_table_category_uindex
    on product_category_table (category_id);

create
    index product_category_table_product_index
    on product_category_table (product_id);

alter table product_category_table
    add constraint product_category_table_category_table_id_fk
        foreign key (category_id) references category_table;

alter table product_category_table
    add constraint product_category_table_product_fk
        foreign key (product_id) references product_table;

alter table product_table
    add category_id int;

alter table product_table
    add constraint product_category_fk
        foreign key (category_id) references category_table;

CREATE SEQUENCE hibernate_sequence START 1;
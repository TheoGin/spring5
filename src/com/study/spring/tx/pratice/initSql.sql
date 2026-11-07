drop table if exists seller;
create table seller
(
    id      int primary key,
    name    varchar(20)    not null,
    balance decimal(10, 2) not null
);

insert into seller
values (1, '小李', 10000.00),
       (2, '小王', 20000.00),
       (3, '小赵', 30000.00);

drop table if exists buyer;
create table buyer
(
    id      int primary key,
    name    varchar(20)    not null,
    balance decimal(10, 2) not null
);

insert into buyer
values (1, '张三', 1000.00),
       (2, '李四', 2000.00),
       (3, '王五', 3000.00);

drop table if exists product;
create table product
(
    id        int primary key,
    name      varchar(20)    not null,
    price     decimal(10, 2) not null,
    stock     int            not null,
    seller_id int            not null
);
insert into product
values (1, '冲牙器', 100.00, 10, 1),
       (2, '电动牙刷', 200.00, 20, 2),
       (3, '吹风机', 300.00, 30, 3);

drop table if exists taoBao;
create table taoBao
(
    id      int primary key,
--     seller_id  int            not null,
--     buyer_id   int            not null,
--     product_id int            not null,
    rate    decimal(10, 2) not null,
    balance decimal(10, 2) not null
);
insert into taoBao
values (1, 0.1, 1000.00),
       (2, 0.1, 2000.00),
       (3, 0.1, 3000.00);

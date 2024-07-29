create table customer (id bigint generated by default as identity, email varchar(255), name varchar(255), primary key (id));
create table item (price numeric(38,2), id bigint generated by default as identity, restaurant_id bigint, description varchar(255), name varchar(255), primary key (id));
create table order_item (quantity integer, id bigint generated by default as identity, item_id bigint, order_id bigint, special_instructions varchar(255), primary key (id));
create table orders (customer_id bigint, id bigint generated by default as identity, restaurant_id bigint, status enum ('DELIVERED','PREPARING','READY','RECEIVED'), primary key (id));
create table restaurant (id bigint generated by default as identity, name varchar(255), primary key (id));
alter table if exists item add constraint FK2ip7t8cv2p1ghfi1e796yet7d foreign key (restaurant_id) references restaurant;
alter table if exists order_item add constraint FKija6hjjiit8dprnmvtvgdp6ru foreign key (item_id) references item;
alter table if exists order_item add constraint FKt4dc2r9nbvbujrljv3e23iibt foreign key (order_id) references orders;
alter table if exists orders add constraint FK624gtjin3po807j3vix093tlf foreign key (customer_id) references customer;
alter table if exists orders add constraint FKi7hgjxhw21nei3xgpe4nnpenh foreign key (restaurant_id) references restaurant;

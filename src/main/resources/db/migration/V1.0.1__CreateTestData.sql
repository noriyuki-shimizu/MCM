insert into users (name, uid, e_mail)
values ('zaqwsx', 'YH3JCcEvxpQyZ15E4jUBfsMiYV12', 'zaqwsx@zaqwsx.jp');

-- ジャンルマスタの初期値を設定
insert into genres (user_id, name)
values
    (1, 'Tops'),
    (1, 'Tee'),
    (1, 'Outer'),
    (1, 'Bottoms'),
    (1, 'Hat'),
    (1, 'Bag'),
    (1, 'Accessories'),
    (1, 'Shoes & Boots'),
    (1, 'All Items');

insert into brands (user_id, name, link, country)
values
    (1, 'bukht', 'http://bukht.com/', '日本');

insert into shops (user_id, name, link, station_name, address, business_hours, tel)
values
    (1, 'O代官山 本店', 'http://store.moc-o.com/', '代官山', '東京都渋谷区猿楽町26-13 グレイス代官山 #202', '12:00 - 20:00 定休日 無し', '03-6416-1187');

insert into clothes (user_id, genre_id, brand_id, shop_id, price, buy_date)
values
    (1, 1, 1, 1, 10000, '2019/01/01');

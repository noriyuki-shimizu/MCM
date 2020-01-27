insert into users (name, uid, e_mail)
values ('zaqwsx', 'YH3JCcEvxpQyZ15E4jUBfsMiYV12', 'zaqwsx@zaqwsx.jp');

-- ジャンルマスタの初期値を設定
insert into genres (user_id, name, color)
values
    (1, 'Tops', 'pink'),
    (1, 'Tee', 'red'),
    (1, 'Outer', 'orange'),
    (1, 'Bottoms', 'green'),
    (1, 'Hat', 'cyan'),
    (1, 'Bag', 'blue'),
    (1, 'Accessories', 'purple'),
    (1, 'Shoes & Boots', 'yellow');

insert into brands (user_id, name, link, country)
values
    (1, 'bukht', 'http://bukht.com/', '日本');

insert into shops (user_id, name, link, station_name, address, business_hours, tel)
values
    (1, 'O代官山 本店', 'http://store.moc-o.com/', '代官山', '東京都渋谷区猿楽町26-13 グレイス代官山 #202', '12:00~20:00', '03-6416-1187');


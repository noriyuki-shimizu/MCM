insert into b_user (name, e_mail, password)
values ('shiminori', 'shiminori@gmail.com', 'password');

-- ジャンルマスタの初期値を設定
insert into m_genre (name)
values
    ('Tops'),
    ('Tee'),
    ('Outer'),
    ('Bottoms'),
    ('Hat'),
    ('Bag'),
    ('Accessories'),
    ('Shoes & Boots'),
    ('All Items');

insert into m_image (name, path)
values
    ('bukht.jpg', '@/images/brand/icon/bukht_icon.jpg');

insert into m_brand (name, link, image_id, country)
values
    ('bukht', 'http://bukht.com/', 1, '日本');

insert into m_shop (name, link, station_name, image_id, address, business_hours, tel)
values
    ('O代官山 本店', 'http://store.moc-o.com/', '代官山', 1, '東京都渋谷区猿楽町26-13 グレイス代官山 #202', '12:00 - 20:00 定休日 無し', '03-6416-1187');

insert into m_clothes (image_id, genre_id, brand_id, shop_id, price, buy_date)
values
    (1, 1, 1, 1, 10000, '2019/01/01');

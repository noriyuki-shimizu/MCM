-- ユーザ
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id bigserial PRIMARY KEY,
    uid varchar(100) NOT NULL,
    name varchar(60),
    e_mail varchar(100) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

-- 画像情報テーブル
DROP TABLE IF EXISTS images;

CREATE TABLE images (
    id bigserial PRIMARY KEY,
    name varchar(60) NOT NULL,
    path varchar(100) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);


-- ジャンル情報テーブル
DROP TABLE IF EXISTS genres;

CREATE TABLE genres (
    id bigserial PRIMARY KEY,
    user_id bigint REFERENCES users(id),
    name varchar(60) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp,
    UNIQUE (name)
);


-- ブランド情報テーブル
DROP TABLE IF EXISTS brands;

CREATE TABLE brands (
    id bigserial PRIMARY KEY,
    user_id bigint REFERENCES users (id),
    name varchar(60) NOT NULL,
    link varchar(100),
    image_id bigint NOT NULL REFERENCES images(id),
    country varchar(15) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

-- 店情報テーブル
DROP TABLE IF EXISTS shops;

CREATE TABLE shops (
    id bigserial PRIMARY KEY,
    user_id bigint REFERENCES users(id),
    name varchar(60) NOT NULL,
    link varchar(100),
    station_name varchar(15) NOT NULL,
    image_id bigint NOT NULL REFERENCES images (id),
    address varchar(100) NOT NULL,
    business_hours varchar(30) NOT NULL,
    tel varchar(15) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

-- 服情報テーブル
DROP TABLE IF EXISTS clothes;

CREATE TABLE clothes (
    id bigserial PRIMARY KEY,
    user_id bigint REFERENCES users(id),
    image_id bigint REFERENCES images(id),
    genre_id bigint NOT NULL REFERENCES genres(id),
    brand_id bigint NOT NULL REFERENCES brands(id),
    shop_id bigint NOT NULL REFERENCES shops(id),
    price integer NOT NULL,
    buy_date date NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

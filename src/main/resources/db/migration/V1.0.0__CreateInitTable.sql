DROP TABLE IF EXISTS clothes;
DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS brands;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS users;

-- ユーザ
CREATE TABLE users (
    id bigserial PRIMARY KEY,
    uid varchar(100) NOT NULL,
    name varchar(60),
    e_mail varchar(100) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

-- 画像情報テーブル
CREATE TABLE images (
    id bigserial PRIMARY KEY,
    path varchar(255) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);


-- ジャンル情報テーブル
CREATE TABLE genres (
    id bigserial PRIMARY KEY,
    user_id bigint NOT NULL REFERENCES users(id),
    name varchar(60) NOT NULL,
    color varchar(15) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);


-- ブランド情報テーブル
CREATE TABLE brands (
    id bigserial PRIMARY KEY,
    user_id bigint NOT NULL REFERENCES users (id),
    name varchar(60) NOT NULL,
    link varchar(100),
    image_id bigint REFERENCES images(id),
    country varchar(15) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

-- 店情報テーブル
CREATE TABLE shops (
    id bigserial PRIMARY KEY,
    user_id bigint NOT NULL REFERENCES users(id),
    name varchar(60) NOT NULL,
    link varchar(100),
    station_name varchar(15) NOT NULL,
    image_id bigint REFERENCES images (id),
    address varchar(100) NOT NULL,
    business_hours varchar(30) NOT NULL,
    tel varchar(15) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

-- 服情報テーブル
CREATE TABLE clothes (
    id bigserial PRIMARY KEY,
    user_id bigint NOT NULL REFERENCES users(id),
    image_id bigint REFERENCES images(id),
    brand_id bigint NOT NULL REFERENCES brands(id),
    shop_id bigint NOT NULL REFERENCES shops(id),
    price integer NOT NULL,
    buy_date date NOT NULL,
    comment varchar(255),
    satisfaction numeric(3, 1) NOT NULL DEFAULT 0.0,
    is_deleted boolean NOT NULL DEFAULT false,
    create_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_date_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_date_time timestamp
);

CREATE TABLE clothing_genres (
    clothing_id bigint NOT NULL REFERENCES clothes(id),
    genre_id bigint NOT NULL REFERENCES genres(id)
)

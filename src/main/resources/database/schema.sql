-- 服情報テーブル
DROP TABLE IF EXISTS clothes;

CREATE TABLE clothes (
    clothes_id bigserial PRIMARY KEY,
    image_id integer,
    genre_id integer NOT NULL,
    brand_id integer NOT NULL,
    shop_id integer NOT NULL,
    price integer NOT NULL,
    buy_date date NOT NULL,
    delete_flag boolean NOT NULL
);

-- ジャンル情報テーブル
DROP TABLE IF EXISTS genre;

CREATE TABLE genre (
    genre_id serial PRIMARY KEY,
    genre_name varchar(60) NOT NULL,
    delete_flag boolean NOT NULL,
    UNIQUE (genre_name)
);

-- 画像情報テーブル
DROP TABLE IF EXISTS image;

CREATE TABLE image (
    image_id serial PRIMARY KEY,
    image_name varchar(60) NOT NULL,
    image_path varchar(100) NOT NULL,
    delete_flag boolean NOT NULL
);

-- ブランド情報テーブル
DROP TABLE IF EXISTS brand;

CREATE TABLE brand (
    brand_id serial PRIMARY KEY,
    brand_name varchar(60) NOT NULL,
    link varchar(100),
    image_id integer NOT NULL,
    country varchar(15) NOT NULL,
    delete_flag boolean NOT NULL
);

-- 店情報テーブル
DROP TABLE IF EXISTS shop;

CREATE TABLE shop (
    shop_id serial PRIMARY KEY,
    shop_name varchar(60) NOT NULL,
    link varchar(100),
    station_name varchar(15) NOT NULL,
    image_id integer NOT NULL,
    address varchar(100) NOT NULL,
    business_hours varchar(30) NOT NULL,
    tel varchar(15) NOT NULL,
    delete_flag boolean NOT NULL
);
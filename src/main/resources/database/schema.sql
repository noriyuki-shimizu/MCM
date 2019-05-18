-- 服情報テーブル
DROP TABLE IF EXISTS m_clothes;

CREATE TABLE m_clothes (
    id bigserial PRIMARY KEY,
    image_id integer,
    genre_id integer NOT NULL,
    brand_id integer NOT NULL,
    shop_id integer NOT NULL,
    price integer NOT NULL,
    buy_date date NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false
);

-- ジャンル情報テーブル
DROP TABLE IF EXISTS m_genre;

CREATE TABLE m_genre (
    id serial PRIMARY KEY,
    name varchar(60) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false,
    UNIQUE (name)
);

-- 画像情報テーブル
DROP TABLE IF EXISTS m_image;

CREATE TABLE m_image (
    id serial PRIMARY KEY,
    name varchar(60) NOT NULL,
    path varchar(100) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false
);

-- ブランド情報テーブル
DROP TABLE IF EXISTS m_brand;

CREATE TABLE m_brand (
    id serial PRIMARY KEY,
    name varchar(60) NOT NULL,
    link varchar(100),
    image_id integer NOT NULL,
    country varchar(15) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false
);

-- 店情報テーブル
DROP TABLE IF EXISTS m_shop;

CREATE TABLE m_shop (
    id serial PRIMARY KEY,
    name varchar(60) NOT NULL,
    link varchar(100),
    station_name varchar(15) NOT NULL,
    image_id integer NOT NULL,
    address varchar(100) NOT NULL,
    business_hours varchar(30) NOT NULL,
    tel varchar(15) NOT NULL,
    delete_flag boolean NOT NULL DEFAULT false
);
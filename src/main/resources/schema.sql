CREATE TABLE IF NOT EXISTS unicorn
(
    id          serial PRIMARY KEY,
    name        character varying(50) COLLATE pg_catalog."default" NOT NULL,
    rented      boolean                                            NOT NULL DEFAULT false,
    rest_time   int8                                                        DEFAULT 15,
    return_time timestamp without time zone,
    CONSTRAINT unicorn_name_key UNIQUE (name)
);

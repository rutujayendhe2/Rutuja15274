
CREATE TABLE public.customer
(
    customer_id bigint NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    email_add character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    phone_no character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;



CREATE TABLE public.product
(
    product_id bigint NOT NULL,
    image_url character varying(255) COLLATE pg_catalog."default",
    price double precision NOT NULL,
    product_name character varying(255) COLLATE pg_catalog."default",
    weight character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (product_id)
)

TABLESPACE pg_default;
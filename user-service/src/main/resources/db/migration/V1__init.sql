CREATE TABLE public.user(
id serial NOT null,
username character varying,
fullname character varying,
email character varying,
password character varying,
dob date,
gender character varying(1),
lang character varying(2) NOT NULL DEFAULT 'es'::character varying,
CONSTRAINT user_pkey PRIMARY KEY (id)
)
with (OIDS=FALSE);

CREATE TABLE public.role(
id serial NOT NULL,
role_name character varying,
CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (OIDS = FALSE );

CREATE TABLE public.user_role(
user_id integer NOT NULL,
role_id integer NOT NULL,
CONSTRAINT user_role_pkey PRIMARY KEY (user_id,role_id),
CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id)
REFERENCES public.role(id) MATCH SIMPLE
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT user_role_user_id FOREIGN KEY(user_id)
REFERENCES public."user" (id) MATCH SIMPLE
ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (OIDS = FALSE);


ALTER TABLE public."user" ALTER COLUMN id TYPE BIGINT USING id::BIGINT;
ALTER TABLE public.user_role ALTER COLUMN user_id TYPE BIGINT USING user_id::BIGINT;

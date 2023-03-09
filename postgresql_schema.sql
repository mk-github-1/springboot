--------------------------------------------------

-- Drop table
DROP TABLE IF EXISTS public.user_role;
DROP TABLE IF EXISTS public.login_user;
DROP TABLE IF EXISTS public.role;

DROP TABLE IF EXISTS public.person;

--------------------------------------------------

-- Table: public.login_user
CREATE TABLE public.login_user
(
    email character varying(256) PRIMARY KEY,
    name character varying(256) NOT NULL,
    password character varying(256) NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    version timestamp NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.login_user OWNER to postgres;

--------------------------------------------------

-- Table: public.role
CREATE TABLE public.role
(
    name character varying(32) PRIMARY KEY,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    version timestamp NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.role OWNER to postgres;

--------------------------------------------------

-- Table: public.user_role
CREATE TABLE public.user_role
(
    user_id character varying(256),
    role_id character varying(32),
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    version timestamp NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
	CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES public.login_user (email)
		ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES public.role (name)
		ON UPDATE NO ACTION ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_role OWNER to postgres;

--------------------------------------------------

-- Table: public.person
CREATE TABLE public.person
(
    "id" integer PRIMARY KEY,
    "name" character varying(256) NOT NULL,
    email character varying(256),
    age integer,
    remarks character varying(256),
    old_id integer,
    "order" integer NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    version timestamp NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.person OWNER to postgres;

--------------------------------------------------

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
    id integer PRIMARY KEY,
    name character varying(128) NOT NULL,
    email character varying(256) NOT NULL,
    password character varying(128) NOT NULL,
    -- createdat timestamp NOT NULL,
    -- updatedat timestamp NOT NULL,
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.login_user OWNER to postgres;

--------------------------------------------------

-- Table: public.role
CREATE TABLE public.role
(
    id integer PRIMARY KEY,
    name character varying(32) NOT NULL,
    -- createdat timestamp NOT NULL,
    -- updatedat timestamp NOT NULL,
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.role OWNER to postgres;

--------------------------------------------------

-- Table: public.user_role
CREATE TABLE public.user_role
(
    user_id integer,
    role_id integer,
    -- createdat timestamp NOT NULL,
    -- updatedat timestamp NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id),
	CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES public.login_user (id)
		ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES public.role (id)
		ON UPDATE NO ACTION ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_role OWNER to postgres;

--------------------------------------------------

-- Table: public.person
CREATE TABLE public.person
(
    id integer PRIMARY KEY,
    name character varying(128) NOT NULL,
    age integer,
    -- remarks character varying(256),
    -- oldid integer,
    -- order integer NOT NULL,
    -- createdat timestamp NOT NULL,
    -- updatedat timestamp NOT NULL,
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.person OWNER to postgres;

--------------------------------------------------
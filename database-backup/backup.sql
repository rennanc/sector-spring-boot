-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION mootrkysnnsbtr;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.hibernate_sequence OWNER TO mootrkysnnsbtr;
GRANT ALL ON SEQUENCE public.hibernate_sequence TO mootrkysnnsbtr;
-- public.profile definition

-- Drop table

-- DROP TABLE public.profile;

CREATE TABLE public.profile (
	id int4 NOT NULL,
	date_register timestamp NULL,
	"name" varchar(255) NULL,
	date_agree_to_terms timestamp NULL,
	CONSTRAINT profile_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE public.profile OWNER TO mootrkysnnsbtr;
GRANT ALL ON TABLE public.profile TO mootrkysnnsbtr;


-- public.user_sector_list definition

-- Drop table

-- DROP TABLE public.user_sector_list;

CREATE TABLE public.user_sector_list (
	user_id int8 NOT NULL,
	sector_list_id int8 NOT NULL,
	CONSTRAINT uk_nbkm947l8evnbu5veas5okdpy UNIQUE (sector_list_id)
);

-- Permissions

ALTER TABLE public.user_sector_list OWNER TO mootrkysnnsbtr;
GRANT ALL ON TABLE public.user_sector_list TO mootrkysnnsbtr;


-- public.sector definition

-- Drop table

-- DROP TABLE public.sector;

CREATE TABLE public.sector (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	parent_id int8 NOT NULL,
	parent_sector_id int8 NULL,
	CONSTRAINT sector_pkey PRIMARY KEY (id),
	CONSTRAINT fki8jf4jx5e64cebu8cfsly3war FOREIGN KEY (parent_sector_id) REFERENCES public.sector(id)
);

-- Permissions

ALTER TABLE public.sector OWNER TO mootrkysnnsbtr;
GRANT ALL ON TABLE public.sector TO mootrkysnnsbtr;


-- public.profile_list definition

-- Drop table

-- DROP TABLE public.profile_list;

CREATE TABLE public.profile_list (
	profile_id int4 NOT NULL,
	list_id int8 NOT NULL,
	CONSTRAINT fkl6c4bir3w4lnfeclv072nfhlk FOREIGN KEY (list_id) REFERENCES public.sector(id),
	CONSTRAINT fkmtsd7y3xexe17sxcd4ymj3j05 FOREIGN KEY (profile_id) REFERENCES public.profile(id)
);

-- Permissions

ALTER TABLE public.profile_list OWNER TO mootrkysnnsbtr;
GRANT ALL ON TABLE public.profile_list TO mootrkysnnsbtr;


-- public.profile_sector_list definition

-- Drop table

-- DROP TABLE public.profile_sector_list;

CREATE TABLE public.profile_sector_list (
	profile_id int8 NOT NULL,
	sector_list_id int8 NOT NULL,
	CONSTRAINT fk7gunxfcl3r0v8mcn6e9km1vx6 FOREIGN KEY (sector_list_id) REFERENCES public.sector(id),
	CONSTRAINT fkanav6vxnkgg776fiek2chm6u7 FOREIGN KEY (profile_id) REFERENCES public.profile(id)
);

-- Permissions

ALTER TABLE public.profile_sector_list OWNER TO mootrkysnnsbtr;
GRANT ALL ON TABLE public.profile_sector_list TO mootrkysnnsbtr;




-- Permissions

GRANT ALL ON SCHEMA public TO mootrkysnnsbtr;
GRANT ALL ON SCHEMA public TO public;

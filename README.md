#### - filmesapi

#### Segue abaixo o script da criação do banco postgres12 e pgadmin4:

 
     -- Database: dbfilmes 

     -- DROP DATABASE dbfilmes;

         CREATE DATABASE dbfilmes
              WITH
              OWNER = postgres
              ENCODING = 'UTF8'
              LC_COLLATE = 'Portuguese_Brazil.1252' 
              LC_CTYPE = 'Portuguese_Brazil.1252' 
              TABLESPACE = pg_default 
              CONNECTION LIMIT = -1; 
              
#### Segue abaixo o script das sequencias e das tabelas:

#### Tabela filme

-- SEQUENCE: public.filme_id_seq 

-- DROP SEQUENCE public.filme_id_seq; 

CREATE SEQUENCE public.filme_id_seq 
    INCREMENT 1  
    START 1     
    MINVALUE 1   
    MAXVALUE 9223372036854775807  
    CACHE 1;  

ALTER SEQUENCE public.filme_id_seq  
    OWNER TO postgres;  
    
      -- Table: public.filme

      -- DROP TABLE public.filme;

      CREATE TABLE public.filme
      (
          id bigint NOT NULL DEFAULT nextval('filme_id_seq'::regclass),
          ano_lancamento character varying(255) COLLATE pg_catalog."default",
          produtor character varying(255) COLLATE pg_catalog."default",
          protagonista character varying(255) COLLATE pg_catalog."default",
          sinopse character varying(255) COLLATE pg_catalog."default",
          titulo character varying(255) COLLATE pg_catalog."default",
          media_avaliacao double precision,
          CONSTRAINT filme_pkey PRIMARY KEY (id)
      )

      TABLESPACE pg_default;

      ALTER TABLE public.filme
          OWNER to postgres;
          
#### Tabela avaliacao

-- SEQUENCE: public.avaliacao_id_seq  <br/>

-- DROP SEQUENCE public.avaliacao_id_seq;  <br/>

CREATE SEQUENCE public.avaliacao_id_seq  <br/>
    INCREMENT 1  <br/>
    START 1     <br/>
    MINVALUE 1   <br/>
    MAXVALUE 9223372036854775807  <br/>
    CACHE 1; <br/>

ALTER SEQUENCE public.avaliacao_id_seq <br/>
    OWNER TO postgres; <br/>
    

-- Table: public.avaliacao <br/>

-- DROP TABLE public.avaliacao;<br/>

CREATE TABLE public.avaliacao<br/>
(<br/>
    id bigint NOT NULL DEFAULT nextval('avaliacao_id_seq'::regclass),<br/>
    comentario character varying(255) COLLATE pg_catalog."default",<br/>
    nome character varying(255) COLLATE pg_catalog."default",<br/>
    nota_avaliacao double precision,<br/>
    filme_id bigint,<br/>
    CONSTRAINT avaliacao_pkey PRIMARY KEY (id),<br/>
    CONSTRAINT fk8m7bswgbfp997q7gbd79en1bu FOREIGN KEY (filme_id)<br/>
        REFERENCES public.filme (id) MATCH SIMPLE<br/>
        ON UPDATE NO ACTION<br/>
        ON DELETE NO ACTION<br/>
)<br/>

TABLESPACE pg_default;<br/>

ALTER TABLE public.avaliacao<br/>
    OWNER to postgres;<br/>
             

CREATE TABLE public.dicionario
(
    id                serial4 NOT NULL,
    palavra_original  varchar(255) NULL,
    palavra_traduzida varchar(255) NULL,
    CONSTRAINT dicionario_pkey PRIMARY KEY (id)
);

INSERT INTO public.dicionario (palavra_original, palavra_traduzida)
VALUES ('Eu', 'I');
INSERT INTO public.dicionario (palavra_original, palavra_traduzida)
VALUES ('bebo', 'drink');
INSERT INTO public.dicionario (palavra_original, palavra_traduzida)
VALUES ('água', 'water');
INSERT INTO public.dicionario (palavra_original, palavra_traduzida)
VALUES ('livro', 'book');
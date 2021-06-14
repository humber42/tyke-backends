CREATE SEQUENCE public.tema_id_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE public.tema ALTER COLUMN id SET DEFAULT nextval('public.tema_id_seq');
ALTER SEQUENCE public.tema_id_seq OWNED BY public.tema.id;
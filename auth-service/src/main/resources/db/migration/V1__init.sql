CREATE TABLE public.logs
(
  id             serial8 PRIMARY KEY,
  type_request   character varying,
  url            character varying,
  ip_adress      character varying,
  username_email character varying
);
CREATE UNIQUE INDEX logs_id_uindex
  ON public.logs (id);
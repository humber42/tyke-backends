CREATE TABLE public.notifications
(
  id           serial8 PRIMARY KEY,
  notification varchar(700),
  id_usuario   bigint,
  readed       boolean DEFAULT false
);
CREATE UNIQUE INDEX notifications_id_uindex
  ON public.notifications (id);


CREATE TABLE public.message
(
  id           serial8 PRIMARY KEY,
  message      varchar(700),
  id_from_user bigint,
  id_to_user   bigint,
  received     boolean DEFAULT false,
  readed       boolean DEFAULT false
);
CREATE UNIQUE INDEX message_id_uindex
  ON public.message (id);
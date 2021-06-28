ALTER TABLE public.estrategia_grupo DROP CONSTRAINT estrategia_grupo_id_estrategia_fkey;
ALTER TABLE public.estrategia_grupo
  ADD CONSTRAINT estrategia_grupo_id_estrategia_fkey
FOREIGN KEY (id_estrategia) REFERENCES public.estrategia (id_estrategia) ON DELETE CASCADE;

ALTER TABLE public.estrategia_tema DROP CONSTRAINT estrategia_tema_id_estrategia_fkey;
ALTER TABLE public.estrategia_tema
  ADD CONSTRAINT estrategia_tema_id_estrategia_fkey
FOREIGN KEY (id_estrategia) REFERENCES public.estrategia (id_estrategia) ON DELETE CASCADE;

ALTER TABLE public.jugador_desafio DROP CONSTRAINT jugador_desafio_id_estrategia_fkey;
ALTER TABLE public.jugador_desafio
  ADD CONSTRAINT jugador_desafio_id_estrategia_fkey
FOREIGN KEY (id_estrategia) REFERENCES public.estrategia (id_estrategia) ON DELETE CASCADE;

ALTER TABLE public.jugador_estrategia DROP CONSTRAINT jugador_estrategia_id_estrategia_fkey;
ALTER TABLE public.jugador_estrategia
  ADD CONSTRAINT jugador_estrategia_id_estrategia_fkey
FOREIGN KEY (id_estrategia) REFERENCES public.estrategia (id_estrategia) ON DELETE CASCADE;

ALTER TABLE public.jugador_insignia DROP CONSTRAINT jugador_insignia_id_insignia_fkey;
ALTER TABLE public.jugador_insignia
  ADD CONSTRAINT jugador_insignia_id_insignia_fkey
FOREIGN KEY (id_insignia) REFERENCES public.insignia (id_insignia) ON DELETE CASCADE;

ALTER TABLE public.jugador_regalo DROP CONSTRAINT jugador_regalo_id_regalo_fkey;
ALTER TABLE public.jugador_regalo
  ADD CONSTRAINT jugador_regalo_id_regalo_fkey
FOREIGN KEY (id_regalo) REFERENCES public.regalo (id_regalo) ON DELETE CASCADE;

ALTER TABLE public.regalo DROP CONSTRAINT regalo_id_tipo_regalo_fkey;
ALTER TABLE public.regalo
  ADD CONSTRAINT regalo_id_tipo_regalo_fkey
FOREIGN KEY (id_tipo_regalo) REFERENCES public.tipo_regalo (id_tipo_regalo) ON DELETE CASCADE;
ALTER TABLE public.regalo DROP CONSTRAINT regalo_id_otorgamiento_fkey;
ALTER TABLE public.regalo
  ADD CONSTRAINT regalo_id_otorgamiento_fkey
FOREIGN KEY (id_otorgamiento) REFERENCES public.otorgamiento (id_otorgamiento) ON DELETE CASCADE;
ALTER TABLE public.bonificacion_pregunta_tiempo DROP CONSTRAINT fkey_bonificacion_pregunta_tiempo;
ALTER TABLE public.bonificacion_pregunta_tiempo
  ADD CONSTRAINT fkey_bonificacion_pregunta_tiempo
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;

ALTER TABLE public.feedback DROP CONSTRAINT fkey_feedback_pregunta_pkey;
ALTER TABLE public.feedback
  ADD CONSTRAINT fkey_feedback_pregunta_pkey
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;

ALTER TABLE public.pista DROP CONSTRAINT pista_tipo_pista___fk;
ALTER TABLE public.pista
  ADD CONSTRAINT pista_tipo_pista___fk
FOREIGN KEY (id_tipo_pista) REFERENCES public.tipo_pista (id) ON DELETE CASCADE;

ALTER TABLE public.pista_pregunta DROP CONSTRAINT fk_pista_pregunta_pregunta;
ALTER TABLE public.pista_pregunta
  ADD CONSTRAINT fk_pista_pregunta_pregunta
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;
ALTER TABLE public.pista_pregunta DROP CONSTRAINT fk_pista_pregunta_pista;
ALTER TABLE public.pista_pregunta
  ADD CONSTRAINT fk_pista_pregunta_pista
FOREIGN KEY (id_pista) REFERENCES public.pista (id) ON DELETE CASCADE;

ALTER TABLE public.pregunta DROP CONSTRAINT fkeu_tipo_pregunta_pkey;
ALTER TABLE public.pregunta
  ADD CONSTRAINT fkeu_tipo_pregunta_pkey
FOREIGN KEY (id_tipo_pregunta) REFERENCES public.tipo_pregunta (id) ON DELETE CASCADE;

ALTER TABLE public.pregunta_respuesta DROP CONSTRAINT fkey_pregunta_respuesta_pregunta;
ALTER TABLE public.pregunta_respuesta
  ADD CONSTRAINT fkey_pregunta_respuesta_pregunta
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;
ALTER TABLE public.pregunta_respuesta DROP CONSTRAINT fkey_pregunta_respuesta_respuesta;
ALTER TABLE public.pregunta_respuesta
  ADD CONSTRAINT fkey_pregunta_respuesta_respuesta
FOREIGN KEY (id_respuesta) REFERENCES public.respuesta (id) ON DELETE CASCADE;
ALTER TABLE public.pregunta_respuesta DROP CONSTRAINT pregunta_respuesta___pregunta_padre_fk;
ALTER TABLE public.pregunta_respuesta
  ADD CONSTRAINT pregunta_respuesta___pregunta_padre_fk
FOREIGN KEY (pregunta_padre) REFERENCES public.pregunta (id) ON DELETE CASCADE;

ALTER TABLE public.profile_respuesta_pregunta DROP CONSTRAINT fkey_profile_pregunta_respuesta_respuesta;
ALTER TABLE public.profile_respuesta_pregunta
  ADD CONSTRAINT fkey_profile_pregunta_respuesta_respuesta
FOREIGN KEY (id_respuesta) REFERENCES public.respuesta (id) ON DELETE CASCADE;
ALTER TABLE public.profile_respuesta_pregunta DROP CONSTRAINT fkey_profile_pregunta_respuesta_pregunta;
ALTER TABLE public.profile_respuesta_pregunta
  ADD CONSTRAINT fkey_profile_pregunta_respuesta_pregunta
FOREIGN KEY (id_pregunta) REFERENCES public.pregunta (id) ON DELETE CASCADE;


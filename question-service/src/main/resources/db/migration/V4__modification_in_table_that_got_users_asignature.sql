

--Modification in feedback
ALTER TABLE public.feedback ADD username varchar NULL;
ALTER TABLE public.feedback DROP id_perfil;


--Modification in pregunta
Alter table public.pregunta ADD asignatura varchar NULL;
ALTER TABLE public.pregunta DROP id_asignatura;

--Modification in profile_pregunta_respuesta
ALTER TABLE public.profile_respuesta_pregunta ADD username varchar NULL;
ALTER TABLE public.profile_respuesta_pregunta drop id_profile;


alter table pacientes add column ativo tinyint(20);
update pacientes set ativo = 1; -- Define todos os pacientes como ativos por padrão

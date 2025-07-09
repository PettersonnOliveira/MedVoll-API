alter table medicos add column ativo tinyint(20);
update medicos set ativo = 1; -- Define todos os médicos como ativos por padrão

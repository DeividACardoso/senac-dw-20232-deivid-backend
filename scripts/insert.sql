insert into fabricante(nome, cnpj) values("Irlanda", "32165498732112");
insert into fabricante(nome, cnpj) values("Deus", "51995195115995");
insert into fabricante(nome, cnpj) values("MacroHard", "95195195184159");


insert into produtos(nome, id_fabricante, valor, peso, dt_cadastro) values('Batata', 1, 0.5, 1.0, CURDATE());
insert into produtos(nome, id_fabricante, valor, peso, dt_cadastro) values('Ornitorrinco', 2, 110.5, 21.0, CURDATE());
insert into produtos(nome, id_fabricante, valor, peso, dt_cadastro) values('Controle XBOX totalmente original', 3, 50.5, 2.0, CURDATE());

select * from fabricante f
inner join produtos p on 
f.id = p.id_fabricante
where f.nome = 'Irlanda'

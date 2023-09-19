create table fornecedor(
	id int not null auto_increment primary key,
	nome varchar(100) not null,
	cnpj varchar(11),
	cidade varchar(100),
	cep varchar(8),
	uf varchar(2)
)
INSERT INTO viagem (destino, preco, data_ida, data_volta, descricao, adicional) VALUES ("Veneza - Itália",9890.00, "12/10/2023", "29/10/2023", "Aproveite as belezas de Veneza", "Hospedagem e Tour");

INSERT INTO viagem (destino, preco, data_ida, data_volta, descricao, adicional) VALUES ("Disney World - Orlando",11890.99, "5/11/2023", "15/11/2023", "Divirta-se no mundo mágico da Disney", "Hospedagem e alimentação");


INSERT INTO viagem (destino, preco, data_ida, data_volta, descricao, adicional, tipo_pacote) VALUES ("Las Vegas - Nevada",7299.50, "17/11/2023", "29/11/2023", "Visite Las Vegas, a cidade que nunca dorme", "Hospedagem e tour", "convencional");

INSERT INTO viagem (destino, preco, data_ida, data_volta, descricao, adicional, tipo_pacote) VALUES ("Tokio - Japão",13350.00, "22/11/2023", "29/11/2023", "Conheça o Japão", "Hospedagem e tour", "promocional");

INSERT INTO viagem (destino, preco, data_ida, data_volta, descricao, adicional, tipo_pacote) VALUES ("Balneário Camboriú - Brasil",1150.00, "15/11/2023", "25/11/2023", "Conheça Balneário e suas praias", "Hospedagem e alimentação", "promocional");


INSERT INTO cliente(email, senha) VALUES ("TESTE1", "TESTE1");
delete from viagem where id=1;

use agencia_viagem;

select * from viagem;

select * from reserva;

select * from cliente;

ALTER TABLE cliente
ADD CONSTRAINT unique_email UNIQUE (email);

select * from viagem where tipo_pacote="promocional";
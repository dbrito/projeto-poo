-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.15-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para sistema_bancario
CREATE DATABASE IF NOT EXISTS `sistema_bancario` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistema_bancario`;

-- Copiando estrutura para tabela sistema_bancario.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cpf_cnpj` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `cep` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_cnpj` (`cpf_cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sistema_bancario.cliente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `nome`, `cpf_cnpj`, `telefone`, `cep`, `endereco`, `cidade`, `estado`, `tipo`) VALUES
	(1, 'Douglas dos Santos Brito 2', '01752904583', '11980940524', '05777001', 'Estrada do Campo Limpo', 'São Paulo', 'São Paulo', 'pessoa_fisica'),
	(2, 'Silvio Santos', '666666', '11980940524', '05777001', 'Estrada do Campo Limpo', 'São Paulo', 'São Paulo', 'pessoa_fisica'),
	(14, 'Jo Soares', '123456789', '11 980940524', '05777001', 'Estrada do Campo Limpo, 666', 'São Paulo', 'São Paulo', 'pessoa_fisica');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Copiando estrutura para tabela sistema_bancario.conta
CREATE TABLE IF NOT EXISTS `conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_titular` int(11) DEFAULT NULL,
  `numero_conta` int(11) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `ativo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_conta` (`numero_conta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sistema_bancario.conta: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` (`id`, `id_titular`, `numero_conta`, `senha`, `saldo`, `tipo`, `ativo`) VALUES
	(1, 1, 2708, '123', 679, 'corrente', b'1'),
	(2, 2, 123456, '123', 966, 'corrente', b'1'),
	(3, 14, 66, '123', 850, 'corrente', b'1');
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;

-- Copiando estrutura para tabela sistema_bancario.transacao
CREATE TABLE IF NOT EXISTS `transacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_conta` int(11) DEFAULT NULL,
  `data` datetime DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(50) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `conta_destino` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sistema_bancario.transacao: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
INSERT INTO `transacao` (`id`, `id_conta`, `data`, `tipo`, `valor`, `conta_destino`) VALUES
	(11, 1, '2018-05-28 00:00:00', 'Depositou', 50, 0),
	(12, 1, '2018-05-28 00:00:00', 'Depositou', 5, 0),
	(13, 1, '2018-05-28 00:00:00', 'Sacou', 10, 0),
	(14, 1, '2018-05-28 00:00:00', 'Transferiu', 6, 1),
	(15, 2, '2018-05-28 00:00:00', 'Recebeu', 6, 2),
	(16, 3, '2018-05-28 00:00:00', 'Depositou', 500, 0),
	(17, 3, '2018-05-28 00:00:00', 'Transferiu', 600, 3),
	(18, 1, '2018-05-28 00:00:00', 'Recebeu', 600, 1),
	(19, 3, '2018-05-28 00:00:00', 'Sacou', 50, 0);
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

# euComida API - Backend

## 📌 Visão Geral
O **euComida** é um sistema de pedidos de comida semelhante ao iFood, desenvolvido com **Spring Boot** e **OAuth2** para autenticação. A API permite criar e consultar pedidos, garantindo segurança e escalabilidade.

## 🚀 Tecnologias Utilizadas
- **Spring Boot** (Java mais recente) - Framework para criação de APIs REST.
- **Spring Security + OAuth2** - Autenticação e autorização seguras.
- **PostgreSQL** - Banco de dados relacional para garantir integridade transacional.
- **Docker** - Containerização para ambiente reprodutível.
- **Swagger (OpenAPI)** - Documentação interativa das APIs.
- **SOLID + Clean Code** - Boas práticas de desenvolvimento.

## 📂 Estrutura do Projeto
```
eucomida-api/
│── src/main/java/com/eucomida/
│   ├── controller/   # Endpoints da API
│   ├── service/      # Regras de negócio
│   ├── repository/   # Camada de persistência
│   ├── security/     # Configuração de OAuth2
│   ├── model/        # Entidades JPA
│   ├── dto/          # Objetos de transferência de dados
```

## 🔒 Estratégia de Segurança (OAuth2)
- O usuário faz login via **Google/Facebook** ou provedor próprio.
- O sistema gera um **Access Token** para acesso à API.
- Autorização baseada em **roles (ADMIN, USER, ENTREGADOR)**.

## 📌 Endpoints do MVP
✔ `POST /auth/login` → Autenticação via OAuth2  
✔ `POST /pedidos` → Criar um novo pedido  
✔ `GET /pedidos/{id}/status` → Consultar status do pedido
✔ `PATCH /pedidos/{id}` → Atualizar status do pedido
✔ `GET /pedidos` → Listar todos os pedidos
✔ `GET /usuarios/me` → Consultar informações do usuário autenticado
## ⚙️ Como Rodar o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/juanmramos/eucomida.git
   ```
2. Entre na pasta do projeto:
   ```bash
   cd eucomida-api
   ```
3. Inicie os containers Docker:
   ```bash
   docker-compose up -d
   ```
4. Acesse a API via Swagger:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## 📌 Próximos Passos
- Implementar notificações em tempo real com WebSockets.
- Criar microserviços para maior escalabilidade.
- Desenvolver testes automatizados (JUnit, Mockito).

---
🛠 **Feito com 💙 por [Juan Ramos](https://github.com/juanmramos)**  **

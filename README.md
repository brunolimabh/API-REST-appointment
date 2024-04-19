# API REST Consultório

## 📃 Postman collection: 
<p align="center">
  <img src="https://github.com/brunolimabh/api-consultorio/blob/main/imgs/postman_print.png" width="200px" height="300px" style="vertical-align: middle; margin-right:"200px";">
</p>


#### 🟨 Endpoint para criar consultas
- **Método HTTP:** POST
- **URL:** `http://localhost:8080/appointment`

#### Body da Requisição (JSON):
```json
{
  "name": "Exame de sangue",
  "dateScheduled": "2024-04-25",
  "price": 150.0,
  "location": "Hospital Cruz Azul",
  "doctor": {
    "id": 1
  }
}
```

#### 🟩 Endpoint para listas todas as consultas
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/appointments`

#### 🟩 Endpoint para listas uma consulta pelo id
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/appointments/{id}`

#### 🟩 Endpoint para listas consultas associadas a um doutor
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/appointments/filter-doctor/{doctorId}`

#### 🟩 Endpoint para calcular a média do preço de todas as consultas
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/appointments/avg-price`

#### 🟩 Endpoint para somar o preço de todas as consultas associadas a um doutor
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/appointments/sum-price-doctor/{doctorId}`

#### 🟩 Endpoint para listas consultas associadas a um doutor entre uma data inicial e final
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/appointments/filter-date-doctor/{doctorId}`
- **Params:** `LocalDate dateInitial`, `LocalDate dateFinal` 

#### 🟪 Endpoint para atualizar o nome de uma consulta
- **Método HTTP:** PATCH
- **URL:** `http://localhost:8080/appointments/{id}`
- **Params:** `String name` 


#### 🟥 Endpoint para remover uma consulta
- **Método HTTP:** DELETE
- **URL:** `http://localhost:8080/appointments/{id}`

Todos esses endpoints estão dentro do arquivo PostmanCollection.json



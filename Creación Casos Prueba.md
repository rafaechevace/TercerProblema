## Identificar las variables que se deben tener en cuenta para probar el método de interés.
        - sana: boolean
        - sintomas: boolean
        - contacto: boolean
        - pasado_covid: boolean
        - cartilla_en_regla: boolean
        - temperatura: double
        - humedad: double
        - nieva: boolean
        - llueve: boolean
        - nublado: boolean
        - aforo_max: int
        - confinada: boolean

# Conjunto de Casos de Prueba

## Parámetros y Clases de Equivalencia

| Parámetro             | Clases de Equivalencia                              | Selección de Valores                   | Extremos                                                 |
|-----------------------|-----------------------------------------------------|----------------------------------------|----------------------------------------------------------|
| **sano**              | false, true                                         | false, true                            | false, true                                              |
| **sintomas**          | false, true                                         | false, true                            | false, true                                              |
| **contacto**          | false, true                                         | false, true                            | false, true                                              |
| **pasado_covid**      | false, true                                         | false, true                            | false, true                                              |
| **cartilla_en_regla** | false, true                                         | false, true                            | false, true                                              |
| **temperatura**       | (-∞, 0), [0,15), [15,25), [25,30), [30,35), [35,+∞) | -15, 5, 20, 27, 32, 50                 | -1, 0, 1, 14, 15, 16, 24, 25, 26, 29, 30, 31, 34, 35, 36 |
| **humedad**           | (-∞, 0), [0,15), [15,60), [60,+∞)                   | -800, 12, 37, 80                       | -1, 0, 1, 14, 15, 16, 59, 60, 61                         |
| **nieva**             | false, true                                         | false, true                            | false, true                                              |
| **llueve**            | false, true                                         | false, true                            | false, true                                              |
| **nublado**           | false, true                                         | false, true                            | false, true                                              |
| **aforo_max**         | (-∞, 0), [0, +∞)                                    | -25, 400                               | -1, 0, 1                                                 |
| **confinada**         | false, true                                         | false, true                            | false, true                                              |

## Conjetura de Errores

- **temperatura**: 200
- **humedad**: 220
- **aforo_max**: 1,000,000


## Calcular el número máximo posible de casos de pruebas que se podrían generar a partir de los valores de pruebas (combinatoria).
        - sana: 2
        - sintomas: 2
        - contacto: 2
        - pasado_covid: 2
        - cartilla_en_regla: 2
        - temperatura: 2^64
        - humedad: 2^64
        - nieva: 2
        - llueve: 2
        - nublado: 2
        - aforo_max: 2^32
        - confinada: 2
        
        - TOTAL = 2^169


## Punto 7: Cobertura de Decisiones

### Casos de Prueba

| Decisión | Resultado | Expresión                                                                                     |
|----------|-----------|-----------------------------------------------------------------------------------------------|
| D1       | True      | (sano AND NOT sintomas AND NOT contacto AND pasado_covid AND cartilla_en_regla)               |
| D1       | False     | (sano AND NOT sintomas AND NOT contacto AND pasado_covid AND cartilla_en_regla)               |
| D2       | True      | temperatura < 0 AND humedad < 15 AND (nieva OR llueve)                                        |
| D2       | False     | temperatura < 0 AND humedad < 15 AND (nieva OR llueve)                                        |
| D3       | True      | temperatura < 0 AND humedad < 15 AND NOT (nieva OR llueve)                                    |
| D3       | False     | temperatura < 0 AND humedad < 15 AND NOT (nieva OR llueve)                                    |
| D4       | True      | 0 ≤ temperatura < 15 AND NOT llueve                                                           |
| D4       | False     | 0 ≤ temperatura < 15 AND NOT llueve                                                           |
| D5       | True      | 15 ≤ temperatura < 25 AND NOT llueve AND NOT nublado AND humedad ≤ 60                         |
| D5       | False     | 15 ≤ temperatura < 25 AND NOT llueve AND NOT nublado AND humedad ≤ 60                         |
| D6       | True      | 25 ≤ temperatura < 35 AND NOT llueve                                                          |
| D6       | False     | 25 ≤ temperatura < 35 AND NOT llueve                                                          |
| D7       | True      | temperatura > 30 AND NOT llueve                                                               |
| D7       | False     | temperatura > 30 AND NOT llueve                                                               |


## Punto 8: Cobertura MC/DC

### Casos de Prueba para MC/DC

| Decisión | Condición                                     | Resultado |
|----------|----------------------------------------------|-----------|
| D1       | sano                                         | Afecta    |
| D1       | NOT sintomas                                 | Afecta    |
| D1       | NOT contacto                                 | Afecta    |
| D1       | pasado_covid                                 | Afecta    |
| D1       | cartilla_en_regla                            | Afecta    |
| D2       | temperatura < 0                              | Afecta    |
| D2       | humedad < 15                                 | Afecta    |
| D2       | (nieva OR llueve)                            | Afecta    |
| D3       | temperatura < 0                              | Afecta    |
| D3       | humedad < 15                                 | Afecta    |
| D3       | NOT (nieva OR llueve)                        | Afecta    |
| D4       | 0 ≤ temperatura < 15                         | Afecta    |
| D4       | NOT llueve                                   | Afecta    |
| D5       | 15 ≤ temperatura < 25                        | Afecta    |
| D5       | NOT llueve                                   | Afecta    |
| D5       | NOT nublado                                  | Afecta    |
| D5       | humedad ≤ 60                                 | Afecta    |
| D6       | 25 ≤ temperatura < 35                        | Afecta    |
| D6       | NOT llueve                                   | Afecta    |
| D7       | temperatura > 30                             | Afecta    |
| D7       | NOT llueve                                   | Afecta    |

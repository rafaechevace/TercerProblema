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

| Parámetro          | Clases de Equivalencia                    | Selección de Valores                  | Extremos                      |
|---------------------|-------------------------------------------|----------------------------------------|-------------------------------|
| **sano**           | false, true                              | false, true                            | false, true                   |
| **sintomas**       | false, true                              | false, true                            | false, true                   |
| **contacto**       | false, true                              | false, true                            | false, true                   |
| **pasado_covid**   | false, true                              | false, true                            | false, true                   |
| **cartilla_en_regla** | false, true                           | false, true                            | false, true                   |
| **temperatura**    | (-∞, 0), [0,15), [15,25), [25,30), [30,35), [35,+∞) | -15, 5, 20, 27, 32, 50                | -1, 0, 1, 14, 15, 16, 24, 25, 26, 29, 30, 31, 34, 35, 36 |
| **humedad**        | (-∞, 0), [0,15), [15,60), [60,+∞)         | -800, 12, 37, 80                       | -1, 0, 1, 14, 15, 16, 59, 60, 61 |
| **nieva**          | false, true                              | false, true                            | false, true                   |
| **llueve**         | false, true                              | false, true                            | false, true                   |
| **nublado**        | false, true                              | false, true                            | false, true                   |
| **aforo_max**      | (-∞, 0), [0, +∞)                         | -25, 400                               | -1, 0, 1                     |
| **confinada**      | false, true                              | false, true                            | false, true                   |

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

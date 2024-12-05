##Identificar las variables que se deben tener en cuenta para probar el método de interés.
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

##Calcular el número máximo posible de casos de pruebas que se podrían generar a partir de los valores de pruebas (combinatoria).
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

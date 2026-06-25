// 1. Guardar el tiempo inicial
long tiempoInicio = System.currentTimeMillis();

// ... Dentro del bucle while del juego
if (guess == numeroSecreto) {
// 2. Guardar el tiempo final
long tiempoFin = System.currentTimeMillis();

    // 3. Calcular la diferencia y pasar a segundos
    double tiempoTotal = (tiempoFin - tiempoInicio) / 1000.0;
    
    System.out.println("Congratulations!");
    System.out.printf("⏱️ Time taken: %.2f seconds.%n", tiempoTotal);
}
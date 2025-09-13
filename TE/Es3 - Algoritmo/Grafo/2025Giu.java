/*Si consideri un grafo non orientato G=(V, E) in cui a ciascun vertice vєV è associato un peso reale
w(v). Un cammino <v1, v2, ...,vk> si dice monotono se w(v1) < w(v2) < ... < w(vk), cioè in un cammino
monotono i pesi dei vertici attraversati devono essere in ordine strettamente crescente. Descrivere
un algoritmo ricorsivo che, dato in input G e due vertici s, d є V, restituisce true se e solo se esiste un
cammino monotono che inizia dalla sorgente s e termina nella destinazione d. 

L'algoritmo deve anche stampare i vertici che compongono tale cammino (nell'ordine v1, v2, ... vk 
oppure nell'ordine inverso vk, vk-1, ... v1). 

Determinare inoltre il costo computazionale dell'algoritmo descritto.*/

//-----------------------------------------------------------------------------------------------------

Algoritmo CamminoMonotono (grafo G=(V,E), nodo s, nodo d) --> boolean
    
    // setto a false i mark di tutti i nodi
    foreach v in V do :
        v.mark := false
    
    return CamminoMonotono_RICORSIVO (G, s, d);

Algoritmo CamminoMonotono_RICORSIVO (grafo G=(V,E), nodo s, nodo d) --> boolean
    
    // parto da lui
    s.mark := true;

    if (s == d) then
        print d;
        return true;
    else
        foreach nodo x adiacente_a_s do:   'G.Adj(s)'
            // se in x non ci sono ancora passato e il suo peso è crescente allora
            if (x.mark == false && s.mark < x.mark) then
                // Chiamata ricosiva per vedere se arrivo ad un dunque
                if (CamminoMonotono_RICORSIVO(G, x, d)) then
                    // per stampare i nodi del cammino (NOTA: sarà al contrario il cammino)
                    print s;
                    return true;
        
        return false;


// Complessità O(n+m) vertici e archi perché visita in 
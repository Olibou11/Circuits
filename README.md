# Circuits

Il s'agit d'un programme qui permet de calculer tous les types de circuits avec des résisteurs.

Le résultat finale donne la résistance électrique, le voltage et l'ampèrage de chacun des sous-circuits et du circuit complet.

Voici un exemple de syntaxe a utiliser :

- ( [ ( [ ( [ ( BNNo ONNo ) JNNo ] ONNo ) VNNo ] MVNo ) BVBo ] ONNo )

Légende : 
- [] circuit parallèle
- () circuit série

Les résisteurs sont totalement personnalisables. Il faut simplement suivre le barème de couleurs des résisteurs. La classe enum "CodeCouleur" implémente ce principe.

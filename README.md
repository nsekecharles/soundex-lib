# soundex-lib
rewritten a C# soundex lib in java



l'agorithme du soundex permet de créer des "codes phonétiques" de mot (ou phrase).

Cas d'utilisation (celui qui m'a intéressé il doit en avoir d'autres): génération de suggestion dans le cas d'une auto complétion infructueuse 

exemple: on a cette liste de mots dans notre référentiel (bonjour, jour, bonsoir, toujours, jours) ayant pour code phonétique (bnjr, jr, bnsr, tjrs, jrs)

un utilisateur saisi bon --> une auto complétion classique lui proposera bonjour et bonsoir

un utilisateur saisi ban --> l'auto complétion ne lui proposera rien. Mais en se basant sur le code phonétique de ban (bn) on a (bnjr, bnsr) qui remontent comme code phonétique
possible. Du coup on peut suggérer à l'utilisateur les mots bonjour et bonsoir malgré sa sasie potentiellement erronée (ban) vu qu'on a pas de mots commençant par ban dans notre référentiel

Bien entendu pour que les suggestions soient les plus fiables possible on a besoin d'avoir un maximum de code phonétique du dictionnaire


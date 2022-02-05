# Vavr validation workshop

Validate the domain with Vavr. Use this workshop to practice transforming your domain validation from contracts to the
functional interface of Vavr validation

## How to navigate

Go through the tests in the ```tasks``` package and transform the models from only using contracts in the constructor
into using the Vavr validation library. Make sure you get the most informative error message, without "logging" user
input, and without allowing an object to be initialized without fulfilling the domain rules.

There are of course many possible solutions, but if you want some inspiration, take a look in the solutions package.
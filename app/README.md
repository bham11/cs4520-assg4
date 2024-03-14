# Assignment 4: API Adventures
## By: Brandon Hampstead


Run this app via the normal android studio app run flow. I tested this app on a Pixel 7 emulator.

Github link: https://github.com/bham11/cs4520-assg4

Both the Login and PL Fragment follow MVVM

In the data folder, the database folder holds the entity, dao and database classes

The ProductRepository class manages calling the api and returning the data from either the api or database, or an empty list if the api returns an empty list of products

ProductListViewModel handles the product list live data and observes changes to the list and updates the adapter of the recyclerview if any changes to the data occur
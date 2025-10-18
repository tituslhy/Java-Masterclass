# 🎟️ Assignment: The Generic Ticketing System

## Background:
You’ve been asked to build a tiny ticketing system for a local events app called FunPass. The system sells tickets for different event types — concerts, movies, and sports matches — and each event type has its own extra data (e.g., performer name, movie rating, team names).

Your goal is to design a generic class that can handle all these different ticket types without duplicating code.

⸻

## Requirements:
1.	Create a generic class Ticket<T>. It should store:
- a String ticketId
- a double price
- and an object of type T (the event details).
Example:
- Ticket<Concert> for concert tickets
- Ticket<Movie> for movie tickets
- Ticket<SportsMatch> for sports tickets
2.	Create three event classes:
- Concert with artistName and venue.
- Movie with title and rating.
- SportsMatch with teamA, teamB, and location.
3.	Create a method to print the ticket details.
- Use generics properly — e.g., a method like void printTicketInfo() that can print all the data nicely.
4.	In your main method (or a demo class):
- Create a few tickets of different types (concert, movie, sports).
- Add them to a List<Ticket<?>>.
- Loop through and print all ticket info.
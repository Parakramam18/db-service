package com.raj.stock.dbservice.repository;
/*   RajUser created on 10/5/2019 
inside the package - com.raj.stock.dbservice.repository  */

import com.raj.stock.dbservice.model.Quote;
import com.raj.stock.dbservice.model.Quotes;
import com.raj.stock.dbservice.resource.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;

    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{userName}")
    public List<String>  getQuotes(@PathVariable("userName") final String userName)
    {
//        return quotesRepository.findByUserName(userName).stream()
//                .map(quote -> { return quote.getQuote(); }).collect(Collectors.toList());

        return getQuotesByUserName(userName);

    }

    private List<String> getQuotesByUserName(@PathVariable("userName") String userName) {
        return quotesRepository.findByUserName(userName).stream()
                .map(Quote::getQuote).collect(Collectors.toList());
    }



    @PostMapping("/delete/{userName}")
    public List<String> deleteIT(@PathVariable("userName") String userName)
    {
        List<Quote> quotes = quotesRepository.findByUserName(userName);
        quotesRepository.deleteAll();
        return getQuotesByUserName(userName);
    }


    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes)
    {
        quotes.getQuotes().stream().forEach( quotesObj -> {

            quotesRepository.save(new Quote(quotes.getUserName(),quotesObj));

        });

        return getQuotesByUserName(quotes.getUserName());
    }





}

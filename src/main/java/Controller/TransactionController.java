package Controller;

import com.hei.wallet.models.entities.Transaction;
import com.hei.wallet.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public List<Transaction> getTransactionById(@PathVariable int id) {
        return transactionService.findById(id);
    }

    @PostMapping("/create")
    public List<Transaction> createTransactions(@RequestBody List<Transaction> transactions) {
        return transactionService.saveAll(transactions);
    }

    @PostMapping("/createSingle")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return transactionService.update(id, transaction);
    }

    @DeleteMapping("/{id}")
    public String deleteTransactionById(@PathVariable int id) {
        return transactionService.deleteById(id);
    }

    @GetMapping("/byTransactionType/{type}")
    public Transaction getTransactionByType(@PathVariable String type) {
        return transactionService.findByTransactionType(TransactionTypes.valueOf(type));
    }

    @GetMapping("/byReceiverId/{receiverId}")
    public Transaction getTransactionByReceiverId(@PathVariable int receiverId) {
        return transactionService.findByReceiverId(receiverId);
    }

    @GetMapping("/bySenderId/{senderId}")
    public Transaction getTransactionBySenderId(@PathVariable int senderId) {
        return transactionService.findBySenderId(senderId);
    }
}


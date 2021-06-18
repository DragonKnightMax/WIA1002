import MyQueue;
import java.util.Scanner;

public class Trading {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue<String> shareQ = new MyQueue<>();
        MyQueue<String> priceQ = new MyQueue<>();

        int capitalGainLoss = 0;
        while (true) {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String input = scanner.nextLine();

            // Break if nothing is entered
            if (input.isEmpty()) {
                break;
            }
            else {
                String[] tokens = input.split(" ");
                String buySell = tokens[0];
                String numOfShare = tokens[1];
                String buySellPrice = tokens[4].replace("$", "");

                if (buySell.equalsIgnoreCase("Sell")) {
                    System.out.println("Selling the share now...");
                    int shareToSell = Integer.parseInt(numOfShare);

                    int remainingShare = 0;
                    do {
                        if (!shareQ.isEmpty()) {
                            int share = Integer.parseInt(shareQ.dequeue());
                            int price = Integer.parseInt(priceQ.dequeue());

                            // Sufficient share to sell for the enqueued value
                            if (share >= shareToSell) {
                                capitalGainLoss = capitalGainLoss + shareToSell * (Integer.parseInt(buySellPrice) - price);
                                remainingShare = share - shareToSell;

                                // Re-insert remaining shares after selling back to queue
                                if (remainingShare > 0) {
                                    insertRemaining(shareQ, remainingShare);
                                    insertRemaining(priceQ, price);
                                }

                            }
                            // Not enough share to sell for the enqueued value
                            else {
                                capitalGainLoss = capitalGainLoss + share * (Integer.parseInt(buySellPrice) - price);
                            }

                            System.out.println("Total Capital Gain / Loss: " + capitalGainLoss);
                            shareToSell = shareToSell - share;
                        }
                        else {
                            System.out.println("No share to sell!");
                            shareToSell = 0;
                        }

                    } while (shareToSell > 0);
                }
                else if (buySell.equalsIgnoreCase("Buy")) {
                    System.out.println("Buying now...");
                    shareQ.enqueue(numOfShare);
                    priceQ.enqueue(buySellPrice);
                }
                else {
                    System.out.println("Invalid Input!");
                    continue;
                }

                // Display current queue content
                System.out.println("Queue for Share: " + shareQ);
                System.out.println("Queue for Price: " + priceQ);
                System.out.println();
            }
        }

        System.out.println("Final Capital Gain / Loss: " + capitalGainLoss);
    }

    public static void insertRemaining(MyQueue<String> queue, int remaining) {
        MyQueue<String> temp = new MyQueue<>();
        temp.enqueue(Integer.toString(remaining));
        while (!queue.isEmpty()) {
            temp.enqueue(queue.dequeue());
        }
        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }
    }
}

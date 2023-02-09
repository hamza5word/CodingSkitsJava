package com.hmz.utils.search;

import java.util.HashMap;
import java.util.Map;

public class PageRank {

    // Map from web page to its inbound links
    private final Map<String, String[]> inboundLinks = new HashMap<>();

    // Map from web page to its PageRank score
    private Map<String, Double> pageRanks = new HashMap<>();

    // Damping factor
    private static final double DAMPING = 0.85;

    // Number of iterations to run
    private static final int NUM_ITERATIONS = 10;

    public void addPage(String url, String[] links) {
        inboundLinks.put(url, links);
        pageRanks.put(url, 1.0);
    }

    public void computePageRanks() {
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            // Store the new PageRank scores in a temporary map
            Map<String, Double> newPageRanks = new HashMap<>();

            // Compute the new PageRank score for each page
            for (String url : inboundLinks.keySet()) {
                double sum = 0.0;
                for (String inboundLink : inboundLinks.get(url)) {
                    double inboundLinkPageRank = pageRanks.get(inboundLink);
                    int outboundLinks = inboundLinks.get(inboundLink).length;
                    sum += inboundLinkPageRank / outboundLinks;
                }
                double newPageRank = (1 - DAMPING) + DAMPING * sum;
                newPageRanks.put(url, newPageRank);
            }

            // Update the PageRank scores with the new values
            pageRanks = newPageRanks;
        }
    }

    public double getPageRank(String url) {
        return pageRanks.get(url);
    }

}

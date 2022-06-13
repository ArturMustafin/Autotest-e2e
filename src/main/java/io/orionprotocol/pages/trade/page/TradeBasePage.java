package io.orionprotocol.pages.trade.page;

import io.orionprotocol.pages.trade.blocks.LeftNavigation;
import io.orionprotocol.pages.trade.blocks.TradeHeaderBlock;
import lombok.Getter;

public class TradeBasePage {

    @Getter
    private final LeftNavigation leftNavigation = new LeftNavigation();

    @Getter
    private final TradeHeaderBlock tradeHeaderBlock = new TradeHeaderBlock();
}

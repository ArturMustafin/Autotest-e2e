package io.orionprotocol.pages.main.page;

import io.orionprotocol.pages.main.blocks.FooterBlock;
import io.orionprotocol.pages.main.blocks.MainHeaderBlock;
import lombok.Getter;

public class MainBasePage {

    @Getter
    private final MainHeaderBlock headerBlock = new MainHeaderBlock();
    @Getter
    private final FooterBlock footerBlock = new FooterBlock();
}

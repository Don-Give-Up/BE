package com.virtukch.dongiveupbe.domain.select_product.dataloader;

import com.virtukch.dongiveupbe.domain.select_product.repository.SelectProductRepository;
import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate"})
public class SelectProductDataLoader implements CommandLineRunner {

    private final SelectProductRepository selectProductRepository;

    public SelectProductDataLoader(SelectProductRepository selectProductRepository) {
        this.selectProductRepository = selectProductRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SelectProduct artwork1 = new SelectProduct("호진의 자연 속 여행", "송호진이 직접 그린 자연 풍경화 작품입니다.", 120L,
            "https://png.pngtree.com/thumb_back/fh260/background/20230612/pngtree-in-the-style-of-digital-art-image_2958544.jpg");
        SelectProduct artwork2 = new SelectProduct("채호의 무한 상상", "김채호가 창의적으로 표현한 추상화 작품입니다.", 90L,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr2Jc3CFBXmxDUxGf1zU-TC4ybF_IGuKsKDw&s");
        SelectProduct artwork3 = new SelectProduct("보영의 한 줄 감성", "정보영이 디자인한 멋진 캘리그래피 글귀입니다.", 150L,
            "https://cdn.crowdpic.net/detail-thumb/thumb_d_D8B59C16C47295C07D9D52C9CF821ADF.jpg");
        SelectProduct artwork4 = new SelectProduct("민정의 컬러풀 드림", "박민정이 그린 일러스트 작품입니다.", 200L,
            "https://d2v80xjmx68n4w.cloudfront.net/gigs/lLq7J1682310661.jpg");
        SelectProduct artwork5 = new SelectProduct("유진의 손맛 도자기",
            "박유진이 만든 도자기 작품으로, 정성스럽게 빚어 만든 예술 작품입니다.", 180L,
            "https://cdn.imweb.me/thumbnail/20210327/866828f717370.jpg");

        selectProductRepository.save(artwork1);
        selectProductRepository.save(artwork2);
        selectProductRepository.save(artwork3);
        selectProductRepository.save(artwork4);
        selectProductRepository.save(artwork5);

        log.info("SelectProduct 창작물 스텁 데이터가 삽입되었습니다.");
    }
}

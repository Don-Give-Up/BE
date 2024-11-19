package com.virtukch.dongiveupbe.domain.select_product.dataloader;

import com.virtukch.dongiveupbe.domain.select_product.repository.SelectProductRepository;
import com.virtukch.dongiveupbe.domain.select_product.entity.SelectProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class SelectProductDataLoader implements CommandLineRunner {

    private final SelectProductRepository selectProductRepository;

    public SelectProductDataLoader(SelectProductRepository selectProductRepository) {
        this.selectProductRepository = selectProductRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SelectProduct teacherProduct = SelectProduct.builder()
                .selectProductName("청소 면제 쿠폰")
                .selectProductDescription("선생님이 주시는 특별한 청소 면제 쿠폰입니다.")
                .selectProductViewAmount(50L)
                .selectProductUrl("https://example.com/teacher_product_image.jpg")
                .selectProductPrice(3000)
                .build();

        selectProductRepository.save(teacherProduct);

        log.info("SelectProduct 창작물 및 선생님 상품 스텁 데이터가 삽입되었습니다.");
    }
}

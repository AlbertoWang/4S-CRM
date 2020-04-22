(function($) {
    'use strict'
    var MqL = 1200;
    //最新最全最好的Bootstrap模板：http://www.bootstrapmb.com
    var autoshowTheme = {

        // Main init function
        init : function() {
            this.config();
            this.events();
        },

        // Define vars for caching
        config : function() {
            this.config = {
                $window : $( window ),
                $document : $( document ),
            };
        },

        // Events
        events : function() {
            var self = this;

            // Run on document ready
            self.config.$document.on( 'ready', function() {

                // PreLoader
                self.preLoader();

                // Wow
                self.wowSet();

                // Menu Navigation
                self.menuNav();

                // Search Icon
                self.searchIcon();

                // CTA Menu
                self.cta();

                // Parallax
                self.parallax();

                // Testimonials
                self.testimonials();

                // Counters
                self.counters();

                // Partners
                self.partners();

                // Car Interest
                self.carInterest();

                // Car Carousel
                self.carCarousel();

                // Sticky Header
                self.sticky();

                // Sliding Button
                self.slidingButton();

                // Main Slider
                self.mainSlider();

                // Gallery
                self.gallery();

            } );

            // Run on Window Load
            self.config.$window.on( 'load', function() {

            } );
        },

        // Sticky Header
        sticky: function() {
            var transparentLogo = $('#header .main-logo img').attr('data-transparent-logo');
            var stickyLogo = $('#header .main-logo img').attr('data-sticky-logo');

            $(window).on('scroll load', function() {

                    // CSS adjustment
                    $("#header").css({
                        position: 'fixed',
                    });
            
                    var headerOffset = $("#header").height();

                    if($(window).scrollTop() >= headerOffset){
                        $("#header").addClass('sticky');
                        $(".wrapper-with-transparent-header #header").addClass('sticky').removeClass("transparent-header unsticky");
                    } else {
                        $("#header").removeClass("sticky");
                        $(".wrapper-with-transparent-header #header").addClass('transparent-header unsticky').removeClass("sticky");
                    }

                    if( $('.transparent-header #header').hasClass('sticky')) {
                        $("#header.sticky .main-logo img").attr("src", stickyLogo);
                    } else {
                        $("#header .main-logo img").attr("src", transparentLogo);
                    } 

                    $(window).on('load resize', function() {
                        var headerOffset = $("#header-container").height();
                        $("#wrapper").css({'padding-top': headerOffset});
                    });
             
            });

            $("#header").on('mouseenter', function() {

                    var headerOffset = $("#header").height();

                    if($(window).scrollTop() <= headerOffset){
                        // CSS adjustment
                        $("#header").css({
                            position: 'fixed',
                        });
                        $(".transparent-header #header").addClass('sticky');
                        $("#header.sticky .main-logo img").attr("src", stickyLogo);
                    }
               
            });

            $("#header").on('mouseleave', function() {
                var headerOffset = $("#header").height();
                if($(window).scrollTop() <= headerOffset){
                    $(".transparent-header #header").removeClass("sticky");
                    $("#header .main-logo img").attr("src", transparentLogo);
                }
            });
        },

        // PreLoader
        preLoader: function() {
            if ( $().animsition ) {
                $('.animsition').animsition({
                    inClass: 'fade-in',
                    outClass: 'fade-out',
                    inDuration: 1500,
                    outDuration: 800,
                    loading: true,
                    loadingParentElement: 'body',
                    loadingClass: 'animsition-loading',
                    timeout: false,
                    timeoutCountdown: 5000,
                    onLoadEvent: true,
                    browser: [
                        '-webkit-animation-duration',
                        '-moz-animation-duration',
                        'animation-duration'
                        ],
                    overlay: false,
                    overlayClass: 'animsition-overlay-slide',
                    overlayParentElement: 'body',
                    transition: function(url){ window.location.href = url; }
                });
            }
        },

        // Wow
        wowSet: function() {
            new WOW().init();
        },

        closeNav: function() {
            $('.nav-trigger').removeClass('nav-is-visible');
            $('.primary-nav').removeClass('nav-is-visible');
            $('.has-children ul').addClass('is-hidden');
            $('.has-children a').removeClass('selected');
            $('.moves-out').removeClass('moves-out');
            $('.site-wrapper').removeClass('nav-is-visible').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $('body').removeClass('overflow-hidden');
            });
        },

        toggleSearch: function(type) {
            if (type == "close") {
                //close serach 
                $('.search').removeClass('is-visible');
                $('.search-trigger').removeClass('search-is-visible');
                $('.overlay').removeClass('search-is-visible');
            } else {
                //toggle search visibility
                $('.search').toggleClass('is-visible');
                $('.search-trigger').toggleClass('search-is-visible');
                $('.overlay').toggleClass('search-is-visible');
                if ($(window).width() > MqL && $('.search').hasClass('is-visible')) $('.search').find('input[type="search"]').focus();
                ($('.search').hasClass('is-visible')) ? $('.overlay').addClass('is-visible') : $('.overlay').removeClass('is-visible');
            }
        },

        checkWindowWidth: function() {
            //check window width (scrollbar included)
            var e = window,
                a = 'inner';
            if (!('innerWidth' in window)) {
                a = 'client';
                e = document.documentElement || document.body;
            }
            if (e[a + 'Width'] >= MqL) {
                return true;
            } else {
                return false;
            }
        },

        moveNavigation: function() {
            var navigation = $('.nav:not(.nav-tabs)');
            var desktop = autoshowTheme.checkWindowWidth();
            if (desktop) {
                navigation.detach();
                navigation.insertAfter('.header-buttons');
            } else {
                navigation.detach();
                navigation.insertAfter('.site-wrapper');
            }
        },

        // Menu Navigation
        menuNav: function() {
            //move nav element position according to window width
            autoshowTheme.moveNavigation();

            $(window).on('resize', function () {
                (!window.requestAnimationFrame) ? setTimeout(autoshowTheme.moveNavigation, 300) : window.requestAnimationFrame(autoshowTheme.moveNavigation);
            });

            //mobile - open lateral menu clicking on the menu icon
            $('.nav-trigger').on('click', function (event) {
                event.preventDefault();
                if ($('.site-wrapper').hasClass('nav-is-visible')) {
                    autoshowTheme.closeNav();
                    $('.overlay').removeClass('is-visible');
                } else {
                    $(this).addClass('nav-is-visible');
                    $('.primary-nav').addClass('nav-is-visible');
                    $('.site-wrapper').addClass('nav-is-visible').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                        $('body').addClass('overflow-hidden');
                    });
                    autoshowTheme.toggleSearch('close');
                    $('.overlay').addClass('is-visible');
                }
            });

            //close lateral menu on mobile 
            $('.overlay').on('swiperight', function () {
                if ($('.primary-nav').hasClass('nav-is-visible')) {
                    autoshowTheme.closeNav();
                    $('.overlay').removeClass('is-visible');
                }
            });
            $('.overlay').on('mouseenter', function () {
                autoshowTheme.closeNav();
                autoshowTheme.toggleSearch('close')
                $('.overlay').removeClass('is-visible');
            });

            //prevent default clicking on direct children of .cd-primary-nav 
            $('.primary-nav').children('.has-children').children('a').on('click', function(event){
                event.preventDefault();
            });
            //open submenu
            $('.primary-nav > .has-children').children('a').on('mouseenter', function (event) { 
                if( autoshowTheme.checkWindowWidth() ) {
                event.preventDefault();
                var selected = $(this);
                if( selected.next('ul').hasClass('is-hidden') ) {
                    //desktop version only
                    selected.addClass('selected').next('ul').removeClass('is-hidden').end().parent('.has-children').parent('ul').addClass('moves-out');
                    selected.parent('.has-children').siblings('.has-children').children('ul').addClass('is-hidden').end().children('a').removeClass('selected');
                    $('.overlay').addClass('is-visible');
                }
                //else {
                //  selected.removeClass('selected').next('ul').addClass('is-hidden').end().parent('.has-children').parent('ul').removeClass('moves-out');
                //  $('.overlay').removeClass('is-visible');
                //}
                //autoshowTheme.toggleSearch('close');
                }
            });

            $('.has-children').children('a').on('click', function (event) {
                if (!autoshowTheme.checkWindowWidth()) event.preventDefault();
                var selected = $(this);
                if (selected.next('ul').hasClass('is-hidden')) {
                    //desktop version only
                    selected.addClass('selected').next('ul').removeClass('is-hidden').end().parent('.has-children').parent('ul').addClass('moves-out');
                    selected.parent('.has-children').siblings('.has-children').children('ul').addClass('is-hidden').end().children('a').removeClass('selected');
                    $('.overlay').addClass('is-visible');
                } else {
                    selected.removeClass('selected').next('ul').addClass('is-hidden').end().parent('.has-children').parent('ul').removeClass('moves-out');
                    $('.overlay').removeClass('is-visible');
                }
                autoshowTheme.toggleSearch('close');
            });
            //submenu items - go back link
            $('.go-back').on('click', function () {
                $(this).parent('ul').addClass('is-hidden').parent('.has-children').parent('ul').removeClass('moves-out');
            });
            $('.nav-drop-close').on('click', function () {
                //$(this).parent('ul').addClass('is-hidden').parent('.has-children').parent('ul').removeClass('moves-out');
                $(this).parent('ul').parent('.has-children').children('a').removeClass('selected').next('ul').addClass('is-hidden').end().parent('.has-children').parent('ul').removeClass('moves-out');
                $('.overlay').removeClass('is-visible');
            });
        },

        // Search Icon
        searchIcon: function() {
            //open search form
            $('.search-trigger').on('click', function (event) {
                event.preventDefault();
                autoshowTheme.toggleSearch();
                autoshowTheme.closeNav();
            });            
        },

        // CTA Menu
        cta: function() {
            if ($(".cta-bar").length > 0) {
                $('.cta-bar').stickit({ scope: StickScope.Document, top: 142, className: 'stick' });
            }
            if ($('.cta-bar').length) { 
                var scrollTrigger = 100, // px
                backToTop = function () {
                    var scrollTop = $(window).scrollTop();
                    if (scrollTop > scrollTrigger) {
                        $('.back-to-top').addClass('show');
                    } else {
                        $('.back-to-top').removeClass('show');
                    }
                };

                $(window).on('scroll', function () {
                    backToTop();
                });

                $('.back-to-top').on('click', function (e) {
                    e.preventDefault();
                    $('html,body').animate({
                        scrollTop: 0
                    }, 700);
                });
            }
        },

        // Counters
        counters: function() {
            //Counter activation
            if ( $().countTo ) { 
                $('.counters').appear(function() {
                    $(this).find('.accent').each(function() {
                        var to = $(this).data('to'),
                            speed = $(this).data('speed');
                            
                        $(this).countTo({
                            to: to,
                            speed: speed
                        });
                    });
                });
            }
        },

        //Partner
        partners: function() {           
            if ( $().owlCarousel ) {
                $('.partners').each(function(){
                    var
                    $this = $(this),
                    auto = $this.data("auto"),
                    loop = $this.data("loop"),
                    item = $this.data("column"),
                    item2 = $this.data("column2"),
                    item3 = $this.data("column3"),
                    gap = Number($this.data("gap"));

                    $this.find('.owl-carousel').owlCarousel({
                        loop: loop,
                        margin: gap,
                        nav: false,
                        navigation : false,
                        pagination: true,
                        autoplay: auto,
                        autoplayTimeout: 5000,
                        responsive: {
                            0:{
                                items:item3
                            },
                            600:{
                                items:item2
                            },
                            1000:{
                                items:item
                            }
                        }
                    });
                });
            }   
        },

        // Parallax
        parallax: function() {
            $('.section-bg').parallax("50%", 0.1);
        },

        // Testimonials
        testimonials: function() {
            if ( $().owlCarousel ) {
                $('.testimonials').each(function(){
                    var
                    $this = $(this),
                    auto = $this.data("auto"),
                    loop = $this.data("loop"),
                    item = $this.data("column"),
                    item2 = $this.data("column2"),
                    item3 = $this.data("column3"),
                    gap = Number($this.data("gap"));

                    $this.find('.owl-carousel').owlCarousel({
                        loop: loop,
                        margin: gap,
                        nav: true,
                        navigation : true,
                        pagination: true,
                        autoplay: auto,
                        autoplayTimeout: 5000,
                        responsive: {
                            0:{
                                items:item3
                            },
                            600:{
                                items:item2
                            },
                            1000:{
                                items:item
                            }
                        }
                    });
                });
            }
        },

        // CarCarousel
        carCarousel: function() {
            if ( $().owlCarousel ) {
                $('.car-carousel').each(function(){
                    var
                    $this = $(this),
                    auto = $this.data("auto"),
                    loop = $this.data("loop"),
                    item = $this.data("column"),
                    nav = $this.data("nav"),
                    item2 = $this.data("column2"),
                    item3 = $this.data("column3"),
                    gap = Number($this.data("gap"));

                    $this.find('.owl-carousel').owlCarousel({
                        loop: loop,
                        margin: gap,
                        nav: nav,
                        navigation : nav,
                        pagination: true,
                        autoplay: auto,
                        autoplayTimeout: 5000,
                        responsive: {
                            0:{
                                items:item3
                            },
                            600:{
                                items:item2
                            },
                            1000:{
                                items:item
                            }
                        }
                    });
                });
            }
        },
        
        //Sliding Button Icon
        slidingButton: function() {
            $(window).on('load', function() {
                $(".button.button-sliding-icon").each(function() {
                    var buttonWidth = $(this).outerWidth()+30;
                    $(this).css('width',buttonWidth);
                });
            });
        },

        // Slider Activation
        mainSlider: function() {
            var startSlider = $(".slider-active");
            startSlider.on("init", function(e, slick) {
              var $firstAnimatingElements = $(".single-slider:first-child").find(
                "[data-animation]"
              );
              doAnimations($firstAnimatingElements);
            });
            startSlider.on("beforeChange", function(e, slick, currentSlide, nextSlide) {
              var $animatingElements = $(
                '.single-slider[data-slick-index="' + nextSlide + '"]'
              ).find("[data-animation]");
              doAnimations($animatingElements);
            });
            startSlider.slick({
              autoplay: true,
              autoplaySpeed: 10000,
              fade: true,
              prevArrow:
                '<button type="button" class="slick-prev"><i class="icofont-long-arrow-left"></i>Prev</button>',
              nextArrow:
                '<button type="button" class="slick-next"><i class="icofont-long-arrow-right"></i>Next</button>',
              arrows: false,
              dots: true,
              responsive: [
                { breakpoint: 767, settings: { dots: false, arrows: false } }
              ]
            });

            function doAnimations(elements) {
              var animationEndEvents =
                "webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend";
              elements.each(function() {
                var $this = $(this);
                var $animationDelay = $this.data("delay");
                var $animationType = "animated " + $this.data("animation");
                $this.css({
                  "animation-delay": $animationDelay,
                  "-webkit-animation-delay": $animationDelay
                });
                $this.addClass($animationType).one(animationEndEvents, function() {
                  $this.removeClass($animationType);
                });
              });
            }
        },

        //Gallery Mosaic
        gallery: function() {
            var $container;

            $(window).on('load', function () {
                if ($(".gallery").length) {
                    $container = $('.mosaic').masonry({
                      // options
                      itemSelector: '.grid-item',
                      columnWidth: '.grid-sizer'
                    });
                }
            });

            $('.nav li').click(function () {
                if ($(this).find("a").attr("data-action") == 'gallery') {
                    window.setTimeout(function () {
                        $container.masonry('layout');
                    }, 200);                                
                }
            });

            $('.gallery').magnificPopup({
                type:'image',
                delegate: '.image-link',
                gallery: {
                  enabled: true
                }
            });

        },

        // Car Interest
        carInterest: function() {
            if ($(".car-interest").length > 0) {
                //open interest point description
                $('.interest-point').children('a').on('click', function () {
                    var selectedPoint = $(this).parent('li');
                    if (selectedPoint.hasClass('is-open')) {
                        selectedPoint.removeClass('is-open');
                    } else {
                        selectedPoint.addClass('is-open').siblings('.interest-point.is-open').removeClass('is-open');
                    }
                });
                //close interest point description
                $('.interest-close-info').on('click', function (event) {
                    event.preventDefault();
                    $(this).parents('.interest-point').eq(0).removeClass('is-open');
                });
            }
        }

    };

    // Start
    autoshowTheme.init();

})(jQuery);
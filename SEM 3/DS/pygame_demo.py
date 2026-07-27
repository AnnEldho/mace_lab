import pygame

pygame.init()

screen = pygame.display.set_mode((500, 400))
pygame.display.set_caption("Pygame Demo")

running = True

while running:
    screen.fill((255, 255, 255))

    pygame.draw.circle(screen, (255, 0, 0), (150, 200), 50)
    pygame.draw.rect(screen, (0, 0, 255), (250, 150, 120, 80))
    # Draw Line
    pygame.draw.line(screen, (0,255,0), (50,50), (450,50), 5)

# Draw Ellipse
    pygame.draw.ellipse(screen, (255,165,0), (50,250,150,80))

# Draw Polygon
    pygame.draw.polygon(screen, (128,0,128), [(350,250), (450,300), (400,350)])
    pygame.display.update()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

pygame.quit()
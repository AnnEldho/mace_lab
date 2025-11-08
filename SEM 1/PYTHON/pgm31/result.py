from Graphics.Rectangle import *
from Graphics import Circle
from Graphics.Graphics3D import Cuboid, Sphere

# 3D shapes using selective import
print("Cuboid Area:", Cuboid.area(5, 4, 3))
print("Cuboid Perimeter:", Cuboid.perimeter(5, 4, 3))

print("Sphere Area:", Sphere.area(6))
print("Sphere Perimeter:", Sphere.perimeter(6))

# 2D shapes using selective import
print("Rectangle Area:",area(4, 3))
print("Rectangle Perimeter:",perimeter(4, 3))

print("Circle Area:", Circle.area(5))
print("Circle Perimeter:", Circle.perimeter(5))
